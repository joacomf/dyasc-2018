package ar.edu.untref.dyasc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.untref.dyasc.productos.Libro;
import ar.edu.untref.dyasc.productos.Producto;
import ar.edu.untref.dyasc.productos.Suscripcion;
import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    private static final int DNI_LUIZ_DIAZ = 12304052;
    private static final LocalDate FECHA_NACIMIENTO_LUIZ_DIAZ = LocalDate.of(1978, 2, 2);
    private static final String APELLIDO_USUARIO_DIAZ = "Diaz";
    private static final String NOMBRE_USUARIO_LUIS = "Luis";
    private static final String DIRECCION_DE_LUIS_DIAZ = "Junin 320";

    @Test
    public void seCreaClienteDeNombrePepe() {
        Cliente cliente = new Cliente("Pepe", "Campaner", 1100001, null, null);

        Assert.assertEquals("Pepe", cliente.obtenerNombre());
        Assert.assertEquals("Campaner", cliente.obtenerApellido());
    }

    @Test
    public void seCreaClienteDeNombreLuisYApellidoDiazConDireccionDorrego418YFechaDeNacimientoEl1DeEneroDe1958() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, "Dorrego 418", LocalDate.of(1958, 1, 1));

        Assert.assertEquals(NOMBRE_USUARIO_LUIS, cliente.obtenerNombre());
        Assert.assertEquals(APELLIDO_USUARIO_DIAZ, cliente.obtenerApellido());
        Assert.assertEquals(LocalDate.of(1958, 1, 1), cliente.obtenerFechaNacimiento());
        Assert.assertEquals("Dorrego 418", cliente.obtenerDireccion());
    }

    @Test
    public void seCreaClienteDeNombreLuisYApellidoDiazConDireccionJunin320YFechaDeNacimientoEl3DeMarzoDe1978() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);

        Assert.assertEquals(NOMBRE_USUARIO_LUIS, cliente.obtenerNombre());
        Assert.assertEquals(APELLIDO_USUARIO_DIAZ, cliente.obtenerApellido());
        Assert.assertEquals(FECHA_NACIMIENTO_LUIZ_DIAZ, cliente.obtenerFechaNacimiento());
        Assert.assertEquals(DIRECCION_DE_LUIS_DIAZ, cliente.obtenerDireccion());
    }

    @Test
    public void seObtieneListadoDeProductosVacioDelClienteEnElMes1YAño2018() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);

        LocalDate fecha = LocalDate.of(2018, 1, 1);
        Integer mes = fecha.getMonthValue();
        Integer año = fecha.getYear();

        List<Producto> listaDeProductos = cliente.obtenerListadoDeProductosEnElMesYAñoDeLaFecha(mes, año);

        Assert.assertEquals(new ArrayList<Producto>(), listaDeProductos);
    }

    @Test
    public void seObtieneListadoDeProductosDelClienteEnElMes5YAño2018() {
        Cliente cliente = new Cliente(NOMBRE_USUARIO_LUIS, APELLIDO_USUARIO_DIAZ, DNI_LUIZ_DIAZ, DIRECCION_DE_LUIS_DIAZ, FECHA_NACIMIENTO_LUIZ_DIAZ);
        Producto productoDePrueba = new Libro(25);

        LocalDate fechaDeCompra = LocalDate.of(2018, 5, 12);
        Integer mes = fechaDeCompra.getMonthValue();
        Integer año = fechaDeCompra.getYear();

        ArrayList<Producto> listaStub = new ArrayList<Producto>();
        listaStub.add(productoDePrueba);

        cliente.comprarProducto(productoDePrueba, fechaDeCompra);
        List<Producto> listaDeProductos = cliente.obtenerListadoDeProductosEnElMesYAñoDeLaFecha(mes, año);

        Assert.assertEquals(listaStub, listaDeProductos);
    }
}
