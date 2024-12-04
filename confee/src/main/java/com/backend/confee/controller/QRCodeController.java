package com.backend.confee.controller;

import com.backend.confee.dto.QRCodeRequest;
import com.backend.confee.dto.QrScanRequestDTO;
import com.backend.confee.entity.QRCode;
import com.backend.confee.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/qr")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateQRCode(@RequestBody QRCodeRequest request) {
        try {
            QRCode qrCode = qrCodeService.generateQRCode(request.getTicketId());
            return ResponseEntity.ok("QR code generated successfully for ticket ID: " + qrCode.getTicketId());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating QR code: " + e.getMessage());
        }
    }

    @PostMapping("/scan")
    public ResponseEntity<Map<String, Object>> scanQRCode(@RequestBody QrScanRequestDTO request) {
        Map<String, Object> response = qrCodeService.updateQRCodeStatus(request.getTicketId(), request.getCardName());
        if ((boolean) response.get("success")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }


    @GetMapping("/get/{ticketId}")
    public ResponseEntity<byte[]> getQRCode(@PathVariable String ticketId) {
        try {
            QRCode qrCode = qrCodeService.getQRCodeByTicketId(ticketId);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ticketId + ".png")
                    .body(qrCode.getQrCodeImage());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}