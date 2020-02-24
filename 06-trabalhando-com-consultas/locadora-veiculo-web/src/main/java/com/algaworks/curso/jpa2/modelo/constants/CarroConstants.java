package com.algaworks.curso.jpa2.modelo.constants;

public class CarroConstants {

    public class QUERYNAME {
        public static final String BUSCAR_TODOS = "Carro.buscarTodos";
        public static final String BUSCAR_CARRO_COM_ACESSORIOS = "Carro.buscarCarroComAcessorios";

        private QUERYNAME() { }
    }

    public class QUERIES {
        public static final String BUSCAR_TODOS = "SELECT c FROM Carro c";
        public static final String BUSCAR_CARRO_COM_ACESSORIOS = "SELECT c "
                                                                + " FROM Carro c JOIN c.acessorios a "
                                                                + " WHERE c.codigo = :codigo";
        private QUERIES() {}
    }

    private CarroConstants() { }
}
