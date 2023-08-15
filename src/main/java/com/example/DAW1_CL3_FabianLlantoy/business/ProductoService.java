package com.example.DAW1_CL3_FabianLlantoy.business;

import java.util.List;

import com.example.DAW1_CL3_FabianLlantoy.model.Producto;

public interface ProductoService {
	List<Producto> listaProducto();
	void registrarProducto(Producto producto);
	Producto listaProductoPorId(int id);
	void eliminarProducto(int id);
}
