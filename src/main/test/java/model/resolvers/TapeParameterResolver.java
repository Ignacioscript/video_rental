package model.resolvers;

import model.Tape;
import model.Title;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class TapeParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
         return parameterContext.getParameter().getType() == Tape.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Title title = (Title) new TitleParameterResolver().resolveParameter(parameterContext, extensionContext);
        return new Tape(1, title, 'A');
    }
}
