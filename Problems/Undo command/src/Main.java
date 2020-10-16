interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command{
    Movable entity;
    int xMovement;
    int yMovement;

    @Override
    public void execute() {
        this.entity.setX(this.xMovement);
        this.entity.setY(this.yMovement);
    }

    @Override
    public void undo() {
        this.entity.setX(xMovement - entity.getX());
        this.entity.setY(yMovement - entity.getY());
    }
}

class CommandPutItem implements Command{
    Storable entity;
    String item;

    @Override
    public void execute() {
        this.entity.setInventoryItem(this.entity.getInventoryLength() -1, item);
    }

    @Override
    public void undo() {
        this.entity.setInventoryItem(this.entity.getInventoryLength()-1 , "");

    }
}