package EffectiveJava;

import java.util.Objects;

public class NyPizza extends Pizza {
    public enum Size {S, M, L}

    private final Size size;

    public static class Builder extends Pizza.Builder{
        private final Size size;
        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(final Builder builder) {
        super(builder);
        size = builder.size;
    }
}
