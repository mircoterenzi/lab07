package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberTerminalView implements DrawNumberView {

    @Override
    public void setController(DrawNumberController observer) {
        /* Non è necessario un controller, ci viene richiesta
         * una tipologia di view solo per output. */
    }

    @Override
    public void start() {
        /* Non è necessario perché dobbiamo scrivere su terminale,
         * non abbiamo per esempio un frame del quale va aggiornato lo stato 
         * (vedi DrawNumberSwingView). */
    }

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
    }
    
}
