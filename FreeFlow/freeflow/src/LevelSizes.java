public enum LevelSizes {

    size5(5), size6(6), size7(7);

    private int size;

    private LevelSizes(int size) {
        this.size = size;

    }

    public int getLevelSize() {
        return size;
    }
}

