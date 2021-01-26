package com.nathan.learn.datastructure.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 哈夫曼编码
 * TODO realize zip file and unzip
 * @author nathan
 */
public class HuffmanCode {
    /**
     * 统计byte数组
     * @param arr bytes
     * @return 统计结果
     */
    public Map<Byte, Integer> statistic(byte[] arr) {
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : arr) {
            counts.put(b, counts.getOrDefault(b, 0) + 1);
        }
        return counts;
    }

    /**
     * 获得byte数组的huffman编码表
     */
    public Map<Byte, String> huffmanCode(Map<Byte, Integer> map) {
        Map<Byte, String> codes = new HashMap<>();
        HuffmanTree.Node<Byte> root = new HuffmanTree<>(map).root;
        huffmanCode(root, "", codes);
        return codes;
    }

    /**
     * huffman编码
     */
    public byte[] encode(byte[] arr) {
        Map<Byte, String> codes = huffmanCode(statistic(arr));
        StringBuilder sb = new StringBuilder();
        for (byte b : arr) {
            sb.append(codes.get(b));
        }
        // 统计返回 byte[] huffmanCodeBytes 长度
        int len;
        byte byteLength = (byte) (sb.length() % 8);
        if (byteLength == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + 1;
            // 后面补零
            for (int i = byteLength; i < 8; i++) {
                sb.append('0');
            }
        }

        // 创建 存储压缩后的 byte数组，huffmanCodeBytes[len]记录赫夫曼编码最后一个字节的有效位数
        byte[] huffmanCodeBytes = new byte[len + 1];
        huffmanCodeBytes[len] = byteLength;
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String strByte;
            strByte = sb.substring(i, i + 8);
            // 将strByte 转成一个byte,放入到 huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    private void huffmanCode(HuffmanTree.Node<Byte> node, String code, Map<Byte, String> huffmanCodes) {
        // 前序遍历
        if (node == null) {
            return;
        }
        if (node.data == null) {
            huffmanCode(node.left, code + "0", huffmanCodes);
            huffmanCode(node.right, code + "1", huffmanCodes);
        } else {
            huffmanCodes.put(node.data, code);
        }
    }


    public static void main(String[] args) {
        HuffmanCode huffmanCode = new HuffmanCode();
        System.out.println(Arrays.toString("hello world".getBytes()));
        System.out.println(Arrays.toString(huffmanCode.encode("hello world".getBytes())));
    }
}
