package com.example.DAW1_CL3_FabianLlantoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.DAW1_CL3_FabianLlantoy.business.ProductoService;
import com.example.DAW1_CL3_FabianLlantoy.model.Producto;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	
	@GetMapping("/")
	public String listadoProducto(Model model) {
		model.addAttribute("listaProductos", service.listaProducto());
		return "index";
	}
	
	@GetMapping("/nuevoProducto")
	public String registroProductoFormulario(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "registroProducto";
	}
	
	@PostMapping("guardarProducto")
	public String registroProducto(@ModelAttribute("producto") Producto producto) {
		service.registrarProducto(producto);
		return "redirect:/";
	}
	
	@GetMapping("/actualizarProducto/{id}")
	public String actualizarProductoFormulario(@PathVariable(value="id") int id, Model model) {
		Producto producto = service.listaProductoPorId(id);
		model.addAttribute("producto", producto);
		return "actualizarProducto";
	}
	
	@GetMapping("/eliminarProducto/{id}")
	public String eliminarProducto(@PathVariable(value="id") int id) {
		service.eliminarProducto(id);
		return "redirect:/";
	}

}
