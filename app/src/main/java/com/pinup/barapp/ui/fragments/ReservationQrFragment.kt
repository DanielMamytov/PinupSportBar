package com.pinup.barapp.ui.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.core.graphics.set
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.pinup.barapp.R
import com.pinup.barapp.databinding.FragmentReservationQrBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReservationQrFragment : Fragment() {
    private var _binding: FragmentReservationQrBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<ReservationQrFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservationQrBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val reservationId = args.reservationId
        val qrBitmap = generateQRCode(reservationId)
        binding.ivQr.setImageBitmap(qrBitmap)
        binding.tvOrderId.text = "Reservation #$reservationId"

        binding.btnBackHome.setOnClickListener {
            findNavController().popBackStack(R.id.menuFragment, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun generateQRCode(text: String): Bitmap {
        val size = 512
        val bits = QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, size, size)
        val bmp = createBitmap(size, size, Bitmap.Config.RGB_565)
        for (x in 0 until size) {
            for (y in 0 until size) {
                bmp[x, y] = if (bits[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE
            }
        }
        return bmp
    }
}
