package br.com.loja.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.loja.model.daos.ClientDAO;
import br.com.loja.model.entities.Client;

@ManagedBean(name = "ClientMB")
@SessionScoped
public class ClientMB {
	private Client client = new Client();
	private ClientDAO clientDAO = new ClientDAO();
	private DataModel<Client> listClients;

	public Client getClient() {
		return client;
	}

	public String FormatCPF(String cpf) {
		return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
	}

	public String FormatRG(String rg) {
		return rg.substring(0, 2) + "." + rg.substring(2, 5) + "." + rg.substring(5, 8) + "-" + rg.substring(8, 9);
	}

	public String CleanData(String data) {
		return data.replace("-", "").replaceAll("\\.", "");
	}

	public void NewReg() {
		this.client = new Client();
	}

	public void SelectClient() {
		this.client = listClients.getRowData();
	}

	public DataModel<Client> getListClients() {
		List<Client> list = clientDAO.SelectAll();
		listClients = new ListDataModel<Client> (list);
		return listClients;
	}

	public String DeleteClient() {
		String response = "responses/generics/erro";
		try {
			if(clientDAO.Delete(client)) {
				response = "responses/client/cliente-deletado";
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return response;
	}

	public String UpdateClient() {
		String response = "responses/generics/erro";
		if(client.getName() == "" || client.getEmail() == "" || client.getCpf() == "" || client.getRg() == "") {
			System.out.println("Campos vazios");
			response = "responses/generics/campos-vazios";
		}else {
			try {
				if(clientDAO.Update(client)) {
					response = "responses/client/cliente-editado";
				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return response;
	}

	public String NewClient() {
		String response = "responses/generics/erro";
		if(client.getName() == "" || client.getEmail() == "" || client.getCpf() == "" || client.getRg() == "") {
			System.out.println("Campos vazios");
			response = "responses/generics/campos-vazios";
		}else {
			try {
				if(clientDAO.Insert(client)) {
					response = "responses/client/cliente-cadastrado";
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return response;
	}
}