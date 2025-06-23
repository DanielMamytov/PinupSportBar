package com.pinup.barapp.ui.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import com.pinup.barapp.R
import com.pinup.barapp.databinding.FragmentQrBinding
import androidx.core.graphics.createBitmap
import androidx.core.graphics.set
import androidx.navigation.fragment.findNavController
import com.pinup.barapp.ui.viewmodels.CartViewModel

class QRFragment : Fragment() {

    private var _binding: FragmentQrBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<QRFragmentArgs>()
    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQrBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val orderId = args.orderId
        val qrBitmap = generateQRCode(orderId)
        binding.ivQr.setImageBitmap(qrBitmap)
        binding.tvOrderId.text = "Order #$orderId"

        binding.btnBackHome.setOnClickListener {
            cartViewModel.clearCart()
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
                bmp[x, y] =
                    if (bits[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE
            }
        }
        return bmp
    }
}
