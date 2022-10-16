package es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.ghost_directives;

import es.ucm.fdi.ici.c2223.practica1.grupo09.pacman.game_link.GameContainer;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class EvitarPacman extends GhostDirective {

    @Override
    public MOVE getMove(GHOST ghostType) {
        if(GameContainer.get().isGhostEdible(ghostType)) {
            Integer ghostIndex = GameContainer.get().getGhostCurrentNodeIndex(ghostType);
            Integer pacmanIndex = GameContainer.get().getPacmanCurrentNodeIndex();
            MOVE lastMove = GameContainer.get().getGhostLastMoveMade(ghostType);
            return GameContainer.get().getNextMoveAwayFromTarget(ghostIndex, pacmanIndex, lastMove, DM.PATH);
        }
        return null;
    }
}