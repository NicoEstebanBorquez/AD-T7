package Beans;

public class Concesionario {

    private String pathBDOO;
    private String username;
    private String password;

    public void crearConcesionario() {
        //Creación de los 4 objetos Coche
//        Coche coche1 = new Coche("4526FTR", "Audi", "A3", 9500, false);
    }

    public static void main(String[] args) {
//        Concesionario concesionario = new Concesionario();
//        concesionario.crearConcesionario();

        Venta venta = new Venta(7, "1234ABC");
        
        Coche coche1 = new Coche("2568HRH", "Audi", "A3", 9500, false);
        
        venta.addPropertyChangeListener(coche1);

        
        //Hacemos una venta
       // venta.setMatricula("1234ABC");
        venta.setMatricula(coche1.getMatricula());
        
        
        if(coche1.isVendido()){
            System.out.println("Se ha producido la Venta: #" + venta.getIdVenta());        
        }else{
            System.out.println("Coche no es Vendido");
        }
    }
}
