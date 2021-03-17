public enum LevelSizes {

    size4(4), size5(5), size6(6);

    private int size;

    private LevelSizes(int size) {
        this.size = size;

    }

    public int getLevelSize() {
        return size;
    }
}

