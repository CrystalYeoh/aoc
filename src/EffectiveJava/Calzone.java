package EffectiveJava;

public class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder {
        private boolean sauceInside = false;

        public Builder sauceInside(){
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Calzone(final Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public boolean getSauce(){
        return sauceInside;
    }
}
