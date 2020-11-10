package processamento;

public class Pizzas {
	private String nome;
	private int tamanho;
	private double preco;
	private double precoCm;
	private String cb;
	
	public Pizzas(String nome, int tamanho, double preco) {
		setNome(nome);
		setTamanho(tamanho);
		setPreco(preco);
		setPrecoCm(calculaPrecoCm(tamanho, preco));
	}
	
	public double getPrecoCm() {
		return precoCm;
	}
	public void setPrecoCm(double precoCm) {
		this.precoCm = precoCm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getCb() {
		return cb;
	}
	
	public void setCb(String cb) {
		this.cb = cb;
	}
	
	//calculo de preço por cm da pizza(area total)
	public double calculaPrecoCm(int tamanho, double preco) {
		return preco / (Math.PI * (Math.pow(tamanho/2, 2)));
	}

	//imprime todas as informações
	public String toString() {
		return "" + nome + "    " + tamanho + "   R$" + preco + "   R$" + precoCm + "     "
				+ cb;
	}

	
	
}
