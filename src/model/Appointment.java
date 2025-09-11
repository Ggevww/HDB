package model;

import enums.ServiceType;
import transaction.impl.AppointmentManager;

import java.time.LocalDateTime;

/**
 * Appointment class represents a service appointment with customer details, service type, preferred time, and priority.
 */
public class Appointment {
    String customerName;
    ServiceType serviceType;
    LocalDateTime preferredTime;
    int priority;

    /**
     * Constructs an Appointment object with the specified details and registers it with the AppointmentManager.
     *
     * @param customerName  the name of the customer
     * @param serviceType   the type of service requested
     * @param preferredTime the preferred time for the appointment
     * @param manager       the AppointmentManager to manage this appointment
     */
    public Appointment(String customerName, ServiceType serviceType, LocalDateTime preferredTime, AppointmentManager manager){
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (serviceType == null) {
            throw new IllegalArgumentException("Service type must be specified");
        }
        if (preferredTime == null || preferredTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Preferred time must be in the future");
        }


        this.customerName = customerName;
        this.serviceType = serviceType;
        this.preferredTime = preferredTime;
        manager.addAppointment(this);
        this.priority = manager.getAppointments().indexOf(this) + 1;
    }

    /** Getters */

    public String getCustomerName() { return customerName; }
    public ServiceType getServiceType() { return serviceType; }
    public LocalDateTime getPreferredTime() { return preferredTime; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return customerName + " - " + serviceType + " at " + preferredTime + " (priority " + priority + ")";
    }
}
