package model;

import exceptions.AllocationIncompleteException;

public class Allocation {


    private Integer id;
    private Seat seat;
    private Passager passager;

    private Allocation(Integer id, Seat seat, Passager passager) {
        this.id = id;
        this.seat = seat;
        this.passager = passager;
    }

    public static Allocation factoryAllocation(Integer id, Seat seat, Passager passager) throws AllocationIncompleteException {
        if(seat == null)
            throw new AllocationIncompleteException("AllocationIncompleteException: Seat null");
        if(passager == null)
            throw new AllocationIncompleteException("AllocationIncompleteException: Passager null");

        return new Allocation(id, seat, passager);
    }
}
