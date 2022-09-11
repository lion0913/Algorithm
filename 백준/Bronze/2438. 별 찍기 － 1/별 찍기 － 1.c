#include<stdio.h>


int main(void) {
	int n;
	scanf("%d", &n);
	if (n >= 1 && n <= 100) {
		for(int j=1;j<=n;j++){
			for (int i = 1; i <= j; i++) {
				printf("*");
			}
			printf("\n");
		}
	}
}