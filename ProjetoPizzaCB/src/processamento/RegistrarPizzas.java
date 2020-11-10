package processamento;

public class RegistrarPizzas {
	Pizzas pizzas[] = new Pizzas[1];

	public Pizzas[] getPizzas() {
		return pizzas;
	}

	public void setPizzas(Pizzas[] pizzas) {
		this.pizzas = pizzas;
	}
	
	public String adicionaPizza(Pizzas pizza) {
	
		//verifica se o tamanho ou valor da pizza j� foi informado, em caso negativo adiciona a pizza
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && (pizzas[i].getPreco() == pizza.getPreco() || pizzas[i].getTamanho() == pizza.getTamanho())) {
				return "Tamanho ou valor da pizza j� informados";
				} else {
					if (pizzas[i] == null) {
					pizzas[i] = pizza;
					pizzas = expandArray(pizzas);
					break;
				}
			}
		}  
		return "Opera��o Efetuada com sucesso";
	}
	
	//aumenta o array
	public Pizzas[] expandArray(Pizzas[] pizzas) {
		Pizzas novoPizzas[] = new Pizzas[pizzas.length+1];
		for (int i = 0; i < pizzas.length; i++) {
			novoPizzas[i] = pizzas[i];
		}
		return novoPizzas;
	}

	//ordena as pizzas do melhor custo benef�cio para o pior
	public void ordernarPcm() {
		Pizzas temp;
		for (int i = 1; i < pizzas.length-1; i++) {
		    for (int j = 0; j < i; j++) {
		        if (pizzas[i].getPrecoCm() < pizzas[j].getPrecoCm()) {
		            temp = pizzas[i];
		            pizzas[i] = pizzas[j];
		            pizzas[j] = temp;
		        }
		    }
		}
	}
	
	//calcula a varia��o percentual do custo benef�cio
	public void calculaVP() {
		// Varia��o Percentual = (VF/VI - 1) � 100
		double vp;
		double vi = pizzas[0].getPrecoCm();
		pizzas[0].setCb("Melhor CB");
		for (int i = 1; i < pizzas.length-1; i++) {
			vp = ((pizzas[i].getPrecoCm()/vi)-1)*100;
			int temp = (int) vp;
			pizzas[i].setCb("+"+Integer.toString(temp)+"%");
		}
	}

	
	
	
}
