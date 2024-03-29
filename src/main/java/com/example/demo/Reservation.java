package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "round_trip", nullable = false)
    private boolean isRoundTrip;

    @Column (name = "departure_date", nullable = false)
    private Date departureDate;

    @Column (name = "return_date", nullable = false)
    private Date returnDate;

    @Column(name = "flight_class", nullable = false)
    private String flightClass;

    @Column(name = "number_passengers", nullable = false)
    @Min(1)
    private int numberPassengers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "departure_flight_id")
    private Flight departureFlight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "return_flight_id")
    private Flight returnFlight;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<Passenger> passengers;

    public Reservation() {
    }


    public Reservation(boolean isRoundTrip,
                       Date departureDate,
                       Date returnDate,
                       String flightClass,
                       int numberPassengers,
                       User user,
                       Flight departureFlight,
                       Flight returnFlight) {
        this.isRoundTrip = isRoundTrip;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.flightClass = flightClass;
        this.numberPassengers = numberPassengers;
        this.user = user;
        this.departureFlight = departureFlight;
        this.returnFlight = returnFlight;
    }

    public Reservation(boolean isRoundTrip,
                       Date departureDate,
                       Date returnDate,
                       String flightClass,
                       int numberPassengers,
                       User user,
                       Flight departureFlight,
                       Flight returnFlight,
                       Collection<Passenger> passengers) {
        this.isRoundTrip = isRoundTrip;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.flightClass = flightClass;
        this.numberPassengers = numberPassengers;
        this.user = user;
        this.departureFlight = departureFlight;
        this.returnFlight = returnFlight;
        this.passengers = passengers;
    }

    public boolean getIsRoundTrip() {
        return isRoundTrip;
    }

    public void setIsRoundTrip(boolean isRoundTrip) {
        this.isRoundTrip = isRoundTrip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public int getNumberPassengers() {
        return numberPassengers;
    }

    public void setNumberPassengers(int numberPassengers) {
        this.numberPassengers = numberPassengers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getDepartureFlight() {
        return departureFlight;
    }

    public void setDepartureFlight(Flight departureFlight) {
        this.departureFlight = departureFlight;
    }

    public Flight getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }

    public Collection<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Collection<Passenger> passengers) {
        this.passengers = passengers;
    }
}
