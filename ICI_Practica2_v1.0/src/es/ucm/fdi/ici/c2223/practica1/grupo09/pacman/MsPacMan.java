package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.actions.EvitarFantasma;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.actions.MaximizarPills;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.actions.PickPills;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.actions.PickSuperPill;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.actions.PursueGhost;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.transitions.AreGhostsInDanger;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.transitions.AreGhostsNotInDanger;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.transitions.CanPacmanAlreadyResist;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.transitions.IsGhEdible;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.transitions.IsGhNotEdible;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.transitions.IsPacmanGonnaDie;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.transitions.IsPacmanInDanger;
import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.transitions.IsPacmanNotInDanger;
import es.ucm.fdi.ici.fsm.CompoundState;
import es.ucm.fdi.ici.fsm.FSM;
import es.ucm.fdi.ici.fsm.SimpleState;
import es.ucm.fdi.ici.fsm.observers.ConsoleFSMObserver;
import es.ucm.fdi.ici.fsm.observers.GraphFSMObserver;
import pacman.controllers.PacmanController;
import pacman.game.Game;
import pacman.game.Constants.MOVE;

public class MsPacMan extends PacmanController {

private static final String TEAM_ID = "09";
	
	public MsPacMan() {
		super();
		setName("SrUchuva" + TEAM_ID);
		setTeam("Team" + TEAM_ID);
	}
	
	@Override
	public MOVE getMove(Game game, long timeDue) {
		EvitarFantasma ef = new EvitarFantasma();
		SimpleState pacCanRetreat = new SimpleState("pacCanRetreat", ef);
		MaximizarPills mp = new MaximizarPills();
		SimpleState pacWillDie = new SimpleState("pacWillDie", mp);
		FSM  pacPeFSM = new FSM("PacmanNotInDanger");
		pacPeFSM.add(pacCanRetreat, new IsPacmanGonnaDie(), pacWillDie);
		pacPeFSM.add(pacWillDie, new CanPacmanAlreadyResist(), pacCanRetreat);
		pacPeFSM.ready(pacCanRetreat);
		CompoundState pacmanPeligro = new CompoundState("pacmanPeligro", pacPeFSM);
		
		PursueGhost pg = new PursueGhost();
		SimpleState ghEdible = new SimpleState("ghEdible", pg);
		PickSuperPill psp = new PickSuperPill();
		SimpleState ghNotEdible = new SimpleState("ghNotEdible", psp);
		FSM ghInDangerFSM = new FSM("GhostsInDanger");
		ghInDangerFSM.add(ghEdible, new IsGhNotEdible(), ghNotEdible);
		ghInDangerFSM.add(ghNotEdible, new IsGhEdible(), ghEdible);
		ghInDangerFSM.ready(ghNotEdible);
		CompoundState ghInDanger = new CompoundState("ghInDanger", ghInDangerFSM);
		
		PickPills pp = new PickPills();
		SimpleState ghNotInDanger = new SimpleState("ghNotInDanger", pp);
		FSM  pacNoPeFSM = new FSM("PacmanInDangerFSM");
		pacNoPeFSM.add(ghInDanger, new AreGhostsNotInDanger(), ghNotInDanger);
		pacNoPeFSM.add(ghNotInDanger, new AreGhostsInDanger(), ghInDanger);
		pacNoPeFSM.ready(ghNotInDanger);
		CompoundState pacmanNoPeligro = new CompoundState("pacmanNoPeligro", pacNoPeFSM);
		
		FSM fsm = new FSM("GeneralFSM");
		fsm.add(pacmanPeligro, new IsPacmanNotInDanger(), pacmanNoPeligro);
		fsm.add(pacmanNoPeligro, new IsPacmanInDanger(), pacmanPeligro);
		fsm.ready(pacmanNoPeligro);
		
		fsm.addObserver(new GraphFSMObserver("UchuvaObserver"));
		fsm.addObserver(new ConsoleFSMObserver("GrapeObserver"));
		return fsm.run(new MyInput(game));
	}
}
