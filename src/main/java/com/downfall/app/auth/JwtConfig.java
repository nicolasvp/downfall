package com.downfall.app.auth;

public class JwtConfig {

	// Clave secreta para la generación del token, esta se usa para la firma
	// Nota: No es obligacion implementarla ya que Spring puede generar una llave random pero a modo práctico se implementará acá manualmente
	public static final String SECRET_KEY = "llave.secreta.123123";
	
	// Llave RSA generada con OpenSSL que se utiliza para firmar el token
	public static final String PRIVATE_RSA_KEY = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpQIBAAKCAQEA6+bd0rNrXk6ULAY7ORwyIDXdHJe/Mj5+xHi/x/Rl49oQtzdm\r\n" + 
			"chTLlTUpc6mI/80VfuJPV925UAMbVfpKg2p95EZ+bSCxxhI8pFfHbFRLcGKdJAAC\r\n" + 
			"ItBdnJ2Kkarqif5gsdrvjuAWJIDQeZ4WaKPnY5eTRHPnJqUJAF8mveUz8HSv2jMz\r\n" + 
			"E73JP5Sgsy9thedqrWOKHjdAg3VrDwLJkkbCM8XY0/D6+u4y4+3XU1yKO66/uNAa\r\n" + 
			"C3rV7RIkL1/xWoCkVnpU5FKy7qKcCEszx4zm9Ihn0tPzVFb2oR8VNCsbwCQSnpfN\r\n" + 
			"GaWOUdPeDK7XnbpI8RyqW4QufYBa9DQJVv2G2wIDAQABAoIBAAfDoHdn2lfPREcy\r\n" + 
			"qU5W5Dt1KmLfh7Zyoh97TeyZ2aSnL7eoBiIpFw5BIq0g3lZ0/Ikhj7T3ojrE72hk\r\n" + 
			"BYHPxnb17wFOeytmvEI4dWLWX2lChaOCsI9OxlX6RW5H7tI94hbYetv7+h6XcsUd\r\n" + 
			"8+TbyCjZ+0ncerYl5mbxusezPINkc5rOwsAjA0VJ+4dIQ7Y0RKELx/ukfFLPlhM/\r\n" + 
			"R866r7cZW2/Y3gw/0sMo15qN+r7KGQuCXgMwJrF1gMfNI1P6aBp5dcemtdV17VMe\r\n" + 
			"y/VuUEMycQplnBPvCMZefMYvKLDJufC9PKQadv4h2zgv+/b79NhD95eD8ac2JwEr\r\n" + 
			"zD8WUbkCgYEA+9QI+EbdN91fdeO/u3wPz05ldb4VsNyh0ULzqSgmFoTYyCg7IiLZ\r\n" + 
			"2VaNN1kEcXpRuSbQm7+bEZJNbY/10UgWf0L15kvr3k0N2uBn3lZooJzJOsvwRMfj\r\n" + 
			"RkTGfVQA8x8b+iOK1W24Km5fjB3Rsad1GtpaZ2dBA3OmaNSWyQmvSxUCgYEA789K\r\n" + 
			"NTv+ML1TkmOyRwyTBxkocjQporl4dylNT2l5v8QpaU2O7m46ruM7gU99U+MWjCK+\r\n" + 
			"J9Q4yypw5P3lbAP3fK29IemkQEG2mtDCkVmcLm1DesifQ4zp0D0Z6VTWntgNHNET\r\n" + 
			"NmoqBqa015C5SbB+Z9yB87wuJCLqp41NFyHrRi8CgYEA2wNUbcELwfs4e4oAhSjn\r\n" + 
			"gw8WdGlF6hRoc1t8GEC/p1QQSTub+hs/RaLdnCZCFAMishlM0je4wHZx+nh6fHHq\r\n" + 
			"hvGQdKLQ1vxCsXn7O8YAprbU19rn8pm5UrKbwgHd9ZO3vDtPEkGjKtvlIzIH3i7a\r\n" + 
			"TOlcOJP3We4p6wAAx4Uxu+UCgYEA4k3GA9KnoCsqcJ0woifVn/830f4zxGIuspUB\r\n" + 
			"Zg1tXXCqe7s7RPo02tGJWBBBfyZwIrKurDtzlRZqD08ib/qWVMxIDXbFD/ZzcknL\r\n" + 
			"MwtTfeSSp44n7cFO7Lqcdzsehivww97xuIobOsebJUpn8Ihj4XOQFwjgqi1hL9kC\r\n" + 
			"hO/3bPUCgYEA7lIns8jIp4JkOJGtG7ANrCi2f02X4eueub3XCdliY10XAsHTAJ1c\r\n" + 
			"4zuaCLrZlfQaXKfODNPcVjobE1w60Dfh8HPu0liyKZj690IrbbWImvN4D/SOzQB8\r\n" + 
			"8IyqnULX/NKELaec/O2vJX/IwAOVaP0AZijLMxY4FpmxzCu3pktZxb8=\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	
	// Llave RSA generada con OpenSSL que se utiliza para verificar el token
	public static final String PUBLIC_RSA_KEY = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6+bd0rNrXk6ULAY7ORwy\r\n" + 
			"IDXdHJe/Mj5+xHi/x/Rl49oQtzdmchTLlTUpc6mI/80VfuJPV925UAMbVfpKg2p9\r\n" + 
			"5EZ+bSCxxhI8pFfHbFRLcGKdJAACItBdnJ2Kkarqif5gsdrvjuAWJIDQeZ4WaKPn\r\n" + 
			"Y5eTRHPnJqUJAF8mveUz8HSv2jMzE73JP5Sgsy9thedqrWOKHjdAg3VrDwLJkkbC\r\n" + 
			"M8XY0/D6+u4y4+3XU1yKO66/uNAaC3rV7RIkL1/xWoCkVnpU5FKy7qKcCEszx4zm\r\n" + 
			"9Ihn0tPzVFb2oR8VNCsbwCQSnpfNGaWOUdPeDK7XnbpI8RyqW4QufYBa9DQJVv2G\r\n" + 
			"2wIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";

}
