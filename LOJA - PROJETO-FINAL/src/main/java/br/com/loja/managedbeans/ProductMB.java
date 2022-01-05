package br.com.loja.managedbeans;

import java.util.List;

import java.text.DecimalFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.loja.model.daos.ProductDAO;
import br.com.loja.model.entities.Product;

@ManagedBean(name = "ProductMB")
@SessionScoped
public class ProductMB {
	private Product product = new Product();
	private ProductDAO productDAO = new ProductDAO();
	private DataModel<Product> listProducts;

	public Product getProduct() {
		return product;
	}

	public String FormatNumber(Integer number) {
		return "R$ " + new DecimalFormat("#,##0.00").format(number);
	}

	public void NewReg() {
		this.product = new Product();
	}

	public void SelectProduct() {
		this.product = listProducts.getRowData();
	}

	public DataModel<Product> getListProducts() {
		List<Product> list = productDAO.SelectAll();
		listProducts = new ListDataModel<Product> (list);
		return listProducts;
	}

	public String DeleteProduct() {
		String response = "responses/generics/erro";
		try {
			if(productDAO.Delete(product)) {
				response = "responses/product/produto-deletado";
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return response;
	}

	public String UpdateProduct() {
		String response = "responses/generics/erro";
		if(product.getName() == "" || product.getCost() == null || product.getPrice() == null || product.getQuantity() == null) {
			System.out.println("Campos vazios");
			response = "responses/generics/campos-vazios";
		}else {
			try {
				if(productDAO.Update(product)) {
					response = "responses/product/produto-editado";
				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return response;
	}

	public String NewProduct() {
		String response = "responses/generics/erro";
		if(product.getName() == "" || product.getCost() == null || product.getPrice() == null || product.getQuantity() == null) {
			System.out.println("Campos vazios");
			response = "responses/generics/campos-vazios";
		}else {
			try {
				if(productDAO.Insert(product)) {
					response = "responses/product/produto-cadastrado";
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return response;
	}
}