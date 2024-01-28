#include <Winsock2.h>
#include <ws2tcpip.h> 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define PORT 8090

int main() 
{
    WSADATA wsa;
    if (WSAStartup(MAKEWORD(2, 2), &wsa) != 0) {
        perror("WSAStartup failed");
        return EXIT_FAILURE;
    }

    int server_fd, new_socket, valread;
    struct sockaddr_in address;
    char str[100];
    socklen_t addrlen = sizeof(address);
    char buffer[1024] = { 0 };
    const char* hello = "Hello from server";

    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == INVALID_SOCKET) {
        perror("socket failed");
        return EXIT_FAILURE;
    }
    address.sin_family = AF_INET;
    address.sin_addr.s_addr = INADDR_ANY;
    address.sin_port = htons(PORT);

    if (bind(server_fd, (struct sockaddr*)&address, sizeof(address)) == SOCKET_ERROR) {
        perror("bind failed");
        closesocket(server_fd);
        return EXIT_FAILURE;
    }

    if (listen(server_fd, 3) == SOCKET_ERROR) {
        perror("listen");
        closesocket(server_fd);
        return EXIT_FAILURE;
    }

    if ((new_socket = accept(server_fd, (struct sockaddr*)&address, &addrlen)) == INVALID_SOCKET) {
        perror("accept");
        closesocket(server_fd);
        return EXIT_FAILURE;
    }

    valread = recv(new_socket, str, sizeof(str), 0);
    int i, j, temp;
    int l = strlen(str);
    printf("\nString sent by client: %s\n", str);

    for (i = 0, j = l - 1; i < j; i++, j--) {
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    send(new_socket, str, sizeof(str), 0);
    printf("\nModified string sent to client\n");

    closesocket(new_socket);
    closesocket(server_fd);
    WSACleanup();
    return 0;
}