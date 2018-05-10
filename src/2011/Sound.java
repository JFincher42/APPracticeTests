public class Sound {
    /** the array of values in this sound; guaranteed not to be null */
    private int[] samples;

    /**
     * Changes those values in this sound that have an amplitude greater than limit.
     * Values greater than limit are changed to limit. Values less than -limit are
     * changed to -limit.
     * 
     * @param limit the amplitude limit Precondition: limit ≥ 0
     * @return the number of values in this sound that this method changed
     */
    public int limitAmplitude(int limit) {
        // Initialize our counter
        int count = 0;

        // Traverse the entire samples array
        for (int i=0; i<samples.length; i++){

            // mag is negative is samples[i] is negative
            int mag = Math.abs(samples[i]) / samples[i];

            // Check if the value it outside the limit - if so, reassign it
            if (Math.abs(samples[i])>limit){
                samples[i] = limit * mag;
                count++;
            }
        }

        // How many did we change?
        return count;
    }

    /**
     * Removes all silence from the beginning of this sound. Silence is represented
     * by a value of 0. Precondition: samples contains at least one nonzero value
     * Postcondition: the length of samples reflects the removal of starting silence
     */
    public void trimSilenceFromBeginning() {
        // Find the first non-zero value in samples
        int start = 0;
        while (samples[start]==0)
            start++;
        
        // Create a new array sized to contain just the non-zero values
        int[] newSamples = new int[samples.length-start];

        // Walk both arrays, assigning the values from samples to newSamples
        for (int i=0; i<newSamples.length; i++, start++)
            newSamples[i] = samples[start];

        // Replace samples with newSamples.
        samples = newSamples;
    }
    // There may be instance variables, constructors, and methods that are not
    // shown.
}