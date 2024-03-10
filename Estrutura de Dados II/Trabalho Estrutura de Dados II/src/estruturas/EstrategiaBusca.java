package estruturas;

public enum EstrategiaBusca {
    PRE_ORDEM,
    INTRA_ORDEM,
    POS_ORDEM;

    public static EstrategiaBusca converter(int valor){
        switch (valor){
            case 1:
                return PRE_ORDEM;

            case 2:
                return INTRA_ORDEM;

            case 3:
                return POS_ORDEM;
        }

        return null;
    }
}
