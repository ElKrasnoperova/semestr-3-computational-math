class Functions {
    static double getFunction(int id, double x) {
        switch (id) {
            case 1: return Math.sin(Math.pow(x, 2));
            case 2: return Math.sin((3*x)/2)+0.5;
            case 3: return (x/(Math.pow(x, 4)) + 4);
            case 4: return 1-x;
            case 5: return 1/(Math.sqrt((Math.pow(x,2))+4));
            default: return 0;
        }
    }

    static String[] formulas = {"y = sin(x^2)", "y = sin(3*x/2)+0,5", "y = x/(4+x^4)", "y = 1-x", "y = 1/sqrt(4+x^2)"};
}
