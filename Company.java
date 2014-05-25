package companyanalyzer;

public class Company {
	
	private String name;
	private String industry;
	private double profit;
	private double averageAssets;
	private double ebit;
	private double grossProfit;
	private double roa;
	private double currentAssets;
	private double currentLiabilities;
	private double sharesOutstanding;
	private double inventory;
	private double equity;
	private long revenue;
	
		
	public Company(String name, String industry){
		setName(name);
		setIndustry(industry);
		
	}
	public void loadFinancialInfo(double profit,double ebit, double averageAssets, double grossProfit, double currentAssets, double currentLiabilities,
					double sharesOutstanding, double inventory, double equity,long revenue){
		
		this.profit = profit;
		this.ebit = ebit;
		this.averageAssets = averageAssets;
		this.grossProfit = grossProfit;
		this.currentAssets = currentAssets;
		this.currentLiabilities = currentLiabilities;
		this.sharesOutstanding = sharesOutstanding;
		this.inventory = inventory;
		this.equity = equity;
		this.revenue = revenue;
	}
	
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public double getAverageAssets() {
		return averageAssets;
	}
	public void setAverageAssets(double averageAssets) {
		this.averageAssets = averageAssets;
	}
	public double getEbit() {
		return ebit;
	}
	public void setEbit(double ebit) {
		this.ebit = ebit;
	}
	public double getGrossProfit() {
		return grossProfit;
	}
	public void setGrossProfit(double grossProfit) {
		this.grossProfit = grossProfit;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void loadCompany(){
		
	}
	
	public String toString(){
		return name;
	}
	public double getRoa() {
		return ebit/averageAssets*100;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public double getRoe(){
		return profit/equity*100;
	}
	
	public double getCurrentRatio(){
		return currentAssets/currentLiabilities;
	}
	
	public double getAcidRatio(){
		return (currentAssets-inventory)/currentLiabilities;
	}
	
	public long getRevenue(){
		return revenue;
	}
	
	public double getProfitMargin(){
		return profit/revenue*100;
	}
	
}