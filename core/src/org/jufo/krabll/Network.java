package org.jufo.krabll;


public class Network {
    // binary inputs, neurons and outputs
    boolean[] inputs;
    Neuron[] neurons;
    boolean[] outputs;
    
    public Network(boolean[] inputs, Neuron[] neurons, boolean[] outputs){
        this.inputs = inputs;
        this.neurons = neurons;
        this.outputs = outputs;
    }
    
    // sets the neurons
    public void setNeurons(){
        for(int a = 0;
                a < neurons.length;
                a++){
            for(int b = 0;
                    b < neurons[a].connectedInputs.length;
                    b++){
                if(inputs[b]){
                    neurons[a].activatedInputs++;
                }
            }
        }
    }
    
    // sets the outputs
    public void setOutputs(){
        for(int a = 0;
                a < neurons.length;
                a++){
            if(neurons[a].activatedInputs == neurons[a].threshold){
                for(int b = 0;
                        b < neurons[a].connectedOutputs.length;
                        b++){
                    outputs[b] = true;
                }
            }
        }
    }
    
    // resets the whole network
    public void reset(){
        for(int a = 0;
                a < inputs.length;
                a++){
            inputs[a] = false;
        }
        for(int a = 0;
                a < neurons.length;
                a++){
            neurons[a].activatedInputs = 0;
        }
        for(int a = 0;
                a < outputs.length;
                a++){
            outputs[a] = false;
        }
    }
    
}