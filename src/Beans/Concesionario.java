package Beans;

import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Concesionario {

    private String pathBDOO;
    private String username;
    private String password;

    public Concesionario() {

        //Ruta, username y password de la base de datos
        pathBDOO = "BDConcesionario.neodatis";
        username = "admin";
        password = "f546ad4f";
    }

    public ODB conectarDB() {
        ODB odb = null;
        try {
            //Creación de la base de datos
            odb = ODBFactory.open(pathBDOO, username, password);
        } catch (ODBAuthenticationRuntimeException e) {
            if (odb != null && !odb.isClosed()) {
                odb.close();
            }
        }
        return odb;
    }

    public void crearConcesionario() {
        //Creación de los 4 objetos Coche
        Coche coche1 = new Coche("4526FTR", "Audi", "A3", 9500, false);
        Coche coche2 = new Coche("8542HRT", "BMW", "Serie 1", 19500, false);
        Coche coche3 = new Coche("5833GTW", "Renault", "Megane", 6700, false);
        Coche coche4 = new Coche("2345KRH", "Ford", "Focus", 21300, false);

        //Los 4 Coches son almadenados en la BD
        ODB odb = conectarDB();
        odb.store(coche1);
        odb.store(coche2);
        odb.store(coche3);
        odb.store(coche4);

        odb.close();
    }

    public static void main(String[] args) {

        Concesionario concesionario = new Concesionario();
        //Creación del concesionario:
        concesionario.crearConcesionario();

        //Conexión con la BD:
        ODB odb = concesionario.conectarDB();

        //Se consulta un Coche de la BD. En este ejemplo se obtiene el coche cuyo modelo es "Focus": 
        IQuery consulta = new CriteriaQuery(Coche.class, Where.equal("modelo", "Focus"));
        Coche coche = (Coche) odb.getObjects(consulta).getFirst();

        // Matricula del Coche obtenido de la BD
        String matriculaCocheBD = coche.getMatricula();

        // Se crea una nueva Venta con la matricula del Coche obtenido de la BD
        // y se asocia el emisor con el receptor:
        Venta venta = new Venta();
        venta.addPropertyChangeListener(coche);
        venta.setMatricula(matriculaCocheBD);

        //En este momento el atributo "Vendido" del coche pasa a TRUE
        // Y tras realizar ese cambio se vuelve a almacenar en la BD.
        odb.store(coche);
        odb.close();
    }
}
