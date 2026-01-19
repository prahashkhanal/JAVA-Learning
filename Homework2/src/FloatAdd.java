class FloatAdd {

    // function receiving float values
    static float add(float x, float y) {
        return x + y;
    }

    public static void main(String[] args) {
        float a = 12.5f;
        float b = 7.5f;

        // store result in double in main
        double result = add(a, b);

        System.out.println("Addition Result: " + result);
    }
}
