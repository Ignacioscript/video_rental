package model.resolvers;

import model.Customer;
import model.Order;
import model.Tape;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.time.LocalDate;
import java.util.Date;

public class OrderParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Order.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Customer customer = (Customer) new CustomeParameterResolver().resolveParameter(parameterContext, extensionContext);
        Tape tape =  (Tape) new TapeParameterResolver().resolveParameter(parameterContext, extensionContext);
        LocalDate date  = LocalDate.of(1985, 1,18);
        return new Order(1, customer, tape, date, 'S');
    }
}
