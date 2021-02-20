package vvu.trainning.practice1.transport;

import vvu.trainning.common.Position;
import vvu.trainning.exception.ApplicationError;

public interface Movable {
    void moveTo(Position pos) throws ApplicationError;
}
