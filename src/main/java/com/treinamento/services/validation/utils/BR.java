package com.treinamento.services.validation.utils;

public class BR {

	//CPF
	private static final int[] weigthCPF = {11,10,9,8,7,6,5,4,3,2};
	
	//CNPJ
	private static final int[] weigthCNPJ = {6,5,4,3,2,9,8,7,6,5,4,3,2};
	
	private static int calculate(final String str, final int[] weigth) {
		int sum = 0;
		for (int i = str.length() -1, digit; i >= 0; i--) {
			digit = Integer.parseInt(str.substring(i,i + 1));
			sum += digit * weigth[weigth.length - str.length() + i];
		}
		
		sum = 11 - sum % 11;
		return sum > 9 ? 0 : sum;
	}
	/**
	 * valida cpf
	 * @param ssn
	 * @return
	 */
	public static boolean isValidCPF(final String ssn) {
		if((ssn == null) || (ssn.length() != 11) || ssn.matches(ssn.charAt(0) + "{11}")) return false;
		
		final Integer digit1 = calculate(ssn.substring(0,9), weigthCPF);
		final Integer digit2 = calculate(ssn.substring(0,9) + digit1, weigthCPF);
		return ssn.equals(ssn.substring(0,9) + digit1.toString() + digit2.toString());
	}
	
	/**
	 * valida cnpj
	 * @param tin
	 * @return
	 */
	public static boolean isValidCNPJ(final String tin) {
		if((tin == null) || (tin.length() != 11) || tin.matches(tin.charAt(0) + "{14}")) return false;
		
		final Integer digit1 = calculate(tin.substring(0,12), weigthCNPJ);
		final Integer digit2 = calculate(tin.substring(0,12) + digit1, weigthCNPJ);
		return tin.equals(tin.substring(0,9) + digit1.toString() + digit2.toString());
	}
}
