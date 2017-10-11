package com.github.uuidcode.oi;

import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

public class HelloOptionalImprovementTest {
    public class Setting {
    }

    public class Booking {

    }

    public class Client {

    }

    @Test
    public void isPresentAndGet() {
        final List<String> SETTING_NAMES = List.of("Keymap", "Editor", "Plugins");

        List<Setting> settings =
            SETTING_NAMES.stream()
                .map(this::lookupSettingByNameAsOptional)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println(settings);
    }

    @Test
    public void stream() {
        final List<String> SETTING_NAMES = List.of("Keymap", "Editor", "Plugins");

        List<Setting> settings =
            SETTING_NAMES.stream()
                .map(this::lookupSettingByNameAsOptional)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        System.out.println(settings);
    }

    private Optional<Setting> lookupSettingByNameAsOptional(String name) {
        if ("Editor".equals(name)) {
            return Optional.of(new Setting());
        }

        return Optional.empty();
    }

    @Test
    public void ifElse() {
        Booking bookingReference = new Booking();
        Booking booking = this.lookupBooking(bookingReference);

        if (booking != null) {
            this.displayCheckIn(booking);
        } else {
            this.displayMissingBookingPage();
        }
    }

    @Test
    public void isPresent() {
        Booking bookingReference = new Booking();
        Optional<Booking> bookingOptional = ofNullable(this.lookupBooking(bookingReference));

        if (bookingOptional.isPresent()) {
            this.displayCheckIn(bookingOptional.get());
        } else {
            this.displayMissingBookingPage();
        }
    }

    @Test
    public void isPresentOrElse() {
        Booking bookingReference = new Booking();
        ofNullable(this.lookupBooking(bookingReference))
            .ifPresentOrElse(this::displayCheckIn, this::displayMissingBookingPage);
    }

    @Test
    public void ifNull() {
        Long clientId = 1024L;
        Client client = this.findClient(clientId);

        if (client == null) {
            client = this.loadDefaultClient();
        }
        
        System.out.println(client);
    }

    @Test
    public void orElseGet() {
        Long clientId = 1024L;
        Client client = ofNullable(this.findClient(clientId))
            .orElseGet(() -> this.loadDefaultClient());

        System.out.println(client);
    }

    @Test
    public void or() {
        Long clientId = 1024L;
        Optional<Client> clientOptional = ofNullable(this.findClient(clientId))
            .or(() -> this.loadDefaultClientAsOptional());

        System.out.println(clientOptional);
    }

    private Client loadDefaultClient() {
        return null;
    }

    private Optional<Client> loadDefaultClientAsOptional() {
        return Optional.empty();
    }

    private Client findClient(Long companyId) {
        return null;
    }

    private void displayMissingBookingPage() {
    }

    private void displayCheckIn(Booking booking) {
    }

    private Booking lookupBooking(Booking bookingReference) {
        return null;
    }
}
