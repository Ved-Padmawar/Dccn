#include <iostream>
#include <string>

uint16_t calculateCRC(const std::string& data, uint16_t polynomial) 
{
    uint16_t crc = 0;
    for (char byte : data) 
    {
        crc ^= static_cast<uint16_t>(byte) << 8;
        for (int i = 0; i < 8; i++) 
        {
            if (crc & 0x8000) 
            {
                crc = (crc << 1) ^ polynomial;
            } 
            else 
            {
                crc <<= 1;
            }
        }
    }
    return crc;
}

int main() 
{
    std::string data = "Hello, World!"; 
    uint16_t polynomial = 0x1021;  

    uint16_t crc = calculateCRC(data, polynomial);

    std::cout << "Data: " << data << std::endl;
    std::cout << "CRC: 0x" << std::hex << crc << std::dec << std::endl;

    return 0;
}
