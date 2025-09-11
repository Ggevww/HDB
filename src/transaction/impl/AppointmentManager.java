package transaction.impl;

import model.Appointment;

import java.util.ArrayList;

/**
 * AppointmentManager class manages a list of appointments, allowing addition and retrieval of appointments.
 */
public class AppointmentManager {
    private ArrayList<Appointment> appointments = new ArrayList<>();

    /**
     * Adds an appointment to the list, ensuring no time conflicts and maintaining order by preferred time.
     * @param appointment
     */
    public void addAppointment(Appointment appointment){
        for (Appointment a : appointments) {
            if (a.getPreferredTime().equals(appointment.getPreferredTime())) {
                throw new IllegalArgumentException("Appointment at this time already exists!");
            }
        }
        boolean added = false;
        for (int i = 0; i< appointments.size(); i++) {
            if (appointments.get(i).getPreferredTime().isAfter(appointment.getPreferredTime())) {
                appointments.add(i, appointment);
                added = true;
                break;

            }
        }
        if (!added) {
            appointments.add(appointment);
        }

    }
    /** Getters and Print Method */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    public void printAppointments() {
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }



}
