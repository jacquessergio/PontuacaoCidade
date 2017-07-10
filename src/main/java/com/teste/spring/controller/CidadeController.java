package com.teste.spring.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teste.spring.controller.domain.Regiao;
import com.teste.spring.util.InputIO;

@Controller
public class CidadeController {

	
	private String serviceUrl = "http://wsteste.devedp.com.br/Master/CidadeServico.svc/rest/";
	private RestTemplate rest = new RestTemplate();
	private String wsCidade;
	private Gson gson = new Gson();
	private List<Regiao> getLista;
	
	public CidadeController() {

		if (this.getLista == null) {
			Type listType = new TypeToken<List<Regiao>>() {}.getType();
			this.wsCidade = rest.getForObject(serviceUrl+"BuscaTodasCidades", String.class);
			this.getLista = this.gson.fromJson(wsCidade, listType);
		}

	}

	@RequestMapping(value = "/Lista", method = RequestMethod.GET)
	public String listAll(Model model, @Valid Regiao regiao, BindingResult bindingResult) {

		model.addAttribute("regiao", regiao);
		return "home";
	}

	@RequestMapping(value = "/Lista", method = RequestMethod.POST)
	public String FindOut(Model model, @Valid Regiao regiao, BindingResult bindingResult) {

		if(!bindingResult.hasErrors()){
			
			List<Regiao> novaLista = new ArrayList<Regiao>();

			for (Regiao getRegiao : getLista) {
				
				if (InputIO.checkInput(getRegiao.getNome()).contains(InputIO.checkInput(regiao.getNome())) 
						&&
					InputIO.checkInput(getRegiao.getEstado()).contains(InputIO.checkInput(regiao.getEstado()))) {
					
					novaLista.add(getRegiao);
				}
			}
				
			model.addAttribute("setLista", novaLista);
		}		
		
		model.addAttribute("regiao", regiao);
	
		return "home";
	}

	@RequestMapping(value = "/Lista/Pontuacao", method = RequestMethod.POST)
	public @ResponseBody String getPoint(Regiao regiao , Model model) {

		String getPontuacao = rest.postForObject(serviceUrl+"BuscaPontos",gson.toJson(regiao), String.class);
		
		return getPontuacao;
	}

}
