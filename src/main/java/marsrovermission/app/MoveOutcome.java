package marsrovermission.app;

import marsrovermission.model.Position;

public class MoveOutcome {

    private final boolean operationStatus;
    private String statusMessage;
    private final Position endPosition;
    private Position failedPosition;

    public MoveOutcome(boolean operationStatus, Position endPosition) {
        this.operationStatus = operationStatus;
        this.endPosition = endPosition;
    }

    public MoveOutcome(boolean operationStatus, Position endPosition,
                       Position failedAtPosition, String statusMessage) {
        this.operationStatus = operationStatus;
        this.endPosition = endPosition;
        this.failedPosition = failedAtPosition;
        this.statusMessage = statusMessage;
    }

    public boolean isSuccess() {
        return operationStatus;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public Position getFailedPosition() {
        return failedPosition;
    }

    public String getStatusMessage(){
        return statusMessage;
    }
}
