public enum Status {


    EMPTY ("Пусто"),
    BLACK ("Черный"),
    WHITE ("Белый");

    private String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Tile getTile() {
        if (title.equals("Черный")) return Tile.B;
        if (title.equals("Белый")) return Tile.W;
        throw new IllegalArgumentException("Tile  doesn't exists");
    }


}
