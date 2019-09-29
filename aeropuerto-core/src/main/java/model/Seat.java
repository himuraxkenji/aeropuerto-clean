package model;

import exceptions.SeatIncompleteException;

public class Seat {


    private Integer id;
    private String numberSeat;

    public Seat(Integer id, String numberSeat) {
        this.id = id;
        this.numberSeat = numberSeat;
    }

    public static Seat factorySeat(Integer id, String numberSeat) throws SeatIncompleteException {
        if(numberSeat == "")
            throw new SeatIncompleteException("SeatIncompleteException: NumberSeat Void ");
        if(numberSeat == null)
            throw new SeatIncompleteException("SeatIncompleteException: NumberSeat Null");

        return new Seat(id, numberSeat);
    }
}
