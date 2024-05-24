package peaksoft.pizzademo.application;

public class NotFoundException extends RuntimeException {
    private final Class<?> clazz;
    public NotFoundException(Class<?> clazz) {
        super("%s not found!".formatted(clazz.getSimpleName()));
        this.clazz = clazz;
    }
}
