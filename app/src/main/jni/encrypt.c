#include "com_seven_file_FileEncrypt.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char* encrypt_pwd = "iloveseven";
/*
 *加密
 */
JNIEXPORT void JNICALL Java_com_seven_file_FileEncrypt_encypt(JNIEnv *env,
		jclass jclz, jstring normal_path_jsr, jstring encrypt_path_jsr) {

	const char *normal_path =(*env)->GetStringUTFChars(env,normal_path_jsr,NULL);
	const char *encrypt_path =(*env)->GetStringUTFChars(env,encrypt_path_jsr,NULL);
	FILE *nomal_file = fopen(normal_path, "rb");
	FILE *ecry_file = fopen(encrypt_path, "wb");

	int ch ;
	int i = 0;
	int pwd_len = strlen(encrypt_pwd);
	while ((ch = fgetc(nomal_file)) != EOF) {

		fputc(ch ^ encrypt_pwd[i % pwd_len], ecry_file);
		i++;
	}

	fclose(ecry_file);
	fclose(nomal_file);

}
//解密
JNIEXPORT void JNICALL Java_com_seven_file_FileEncrypt_deEncrypt(JNIEnv *env,
		jclass jclz, jstring encrypt_path_jsr, jstring decrypt_path_jsr) {

	const char *encrypt_path =(*env)->GetStringUTFChars(env,encrypt_path_jsr,NULL);
	const char *decrypt_path =(*env)->GetStringUTFChars(env,decrypt_path_jsr,NULL);

	FILE *encry_file = fopen(encrypt_path, "rb");
	FILE *de_ecry_file = fopen(decrypt_path, "wb");

	int ch ;
	int i = 0;
	int pwd_len = strlen(encrypt_pwd);
	while ((ch =fgetc(encry_file)) != EOF) {

		fputc(ch ^ encrypt_pwd[i % pwd_len], de_ecry_file);
		i++;
	}

	fclose(encry_file);
	fclose(de_ecry_file);


}
