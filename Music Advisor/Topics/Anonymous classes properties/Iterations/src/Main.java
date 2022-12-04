class IteratorExecutor {

    static void performIterationsWithCallback(int numberOfIterations, LoopCallback callback) {
        for (int i = 0; i < numberOfIterations; i++) {
            callback.onNewIteration(i);
        }
    }

    static void startIterations(int numberOfIterations) {
        // invoke the method performIterationsWithCallback here
        performIterationsWithCallback(numberOfIterations, new LoopCallback() {
            @Override
            public void onNewIteration(int iteration) {
                String string = String.format("Iteration: %d", iteration);
                System.out.println(string);
            }
        });
    }
}

// Don't change the code below
interface LoopCallback {

    void onNewIteration(int iteration);
}