package Consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        Customer vinicius = new Customer("Vinícius", "974133884");
        greetCustomer(new Customer("Vinícius", "974133884"));
        greetCustomerConsumer.accept(vinicius);
        System.out.print('\n');
        greetCustomerConsumerV2.accept(vinicius, false);
    }


    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.printf("Hello " + customer.customerName + ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "*********"));

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number " + customer.customerPhoneNumber);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.printf("Hello " + customer.customerName + ", thanks for registering phone number "
                    + customer.customerPhoneNumber);

    record Customer(String customerName, String customerPhoneNumber) {
    }
}
