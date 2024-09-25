"use client"

import { motion } from "framer-motion"
import Image from "next/image"

export default function Component() {
  return (
    <section className="w-full min-h-screen bg-black relative overflow-hidden flex items-center justify-center">
      <motion.div
        className="absolute inset-0 bg-gradient-to-br from-yellow-400/20 to-yellow-600/20"
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 1.5 }}
      />
      <motion.div
        className="absolute bottom-0 right-0 w-1/2 h-1/2 bg-gradient-to-tl from-yellow-500/30 to-transparent rounded-tl-full"
        initial={{ scale: 0, opacity: 0 }}
        animate={{ scale: 1, opacity: 1 }}
        transition={{ duration: 1, delay: 0.5 }}
      />
      <div className="container px-4 md:px-6 relative z-10">
        <div className="flex flex-col items-center space-y-4 text-center">
          <motion.h1
            className="text-3xl font-bold tracking-tighter sm:text-5xl md:text-6xl/none text-white max-w-[800px]"
            initial={{ y: 50, opacity: 0 }}
            animate={{ y: 0, opacity: 1 }}
            transition={{ duration: 0.8, delay: 0.2 }}
          >
            Accede a desarrolladores expertos.
            <motion.span
              className="text-yellow-400 block"
              initial={{ y: 20, opacity: 0 }}
              animate={{ y: 0, opacity: 1 }}
              transition={{ duration: 0.8, delay: 0.6 }}
            >
              Impulsa tu negocio.
            </motion.span>
          </motion.h1>
          <motion.p
            className="max-w-[600px] text-yellow-50 md:text-xl"
            initial={{ y: 20, opacity: 0 }}
            animate={{ y: 0, opacity: 1 }}
            transition={{ duration: 0.8, delay: 0.8 }}
          >
            Obtén los mejores desarrolladores trabajando en tu proyecto sin agotar tu presupuesto.
          </motion.p>
          <motion.div
            className="flex flex-col sm:flex-row gap-4"
            initial={{ y: 20, opacity: 0 }}
            animate={{ y: 0, opacity: 1 }}
            transition={{ duration: 0.8, delay: 1 }}
          >
            <button
              className="bg-yellow-400 text-black hover:bg-yellow-300 transition-colors duration-300"
            >
              Publica un Proyecto
            </button>
            <button
              className="border-yellow-400 text-yellow-400 hover:bg-yellow-400/20 transition-colors duration-300"
            >
              Soy Desarrollador
            </button>
          </motion.div>
        </div>
      </div>
      <motion.div
        className="absolute top-10 left-10 w-20 h-20 bg-yellow-400 rounded-full overflow-hidden"
        animate={{
          scale: [1, 2, 2, 1, 1],
          rotate: [0, 0, 270, 270, 0],
          borderRadius: ["20%", "20%", "50%", "50%", "20%"],
        }}
        transition={{
          duration: 5,
          ease: "easeInOut",
          times: [0, 0.2, 0.5, 0.8, 1],
          repeat: Infinity,
          repeatDelay: 1
        }}
      >
        <Image
          src="https://hebbkx1anhila5yf.public.blob.vercel-storage.com/Tricode-logo-AkL8KF3rRdG2rTS1CMkfk99qIdZ74H.jpg"
          alt="Logo geométrico circular"
          layout="fill"
          objectFit="cover"
        />
      </motion.div>
      <motion.div
        className="absolute bottom-10 right-10 w-32 h-32 bg-yellow-400 rounded-lg overflow-hidden"
        animate={{
          rotateY: 360,
          borderRadius: ["0%", "50%", "0%"],
        }}
        transition={{
          duration: 4,
          ease: "easeInOut",
          repeat: Infinity,
          repeatDelay: 0.5
        }}
      >
        <Image
          src="https://hebbkx1anhila5yf.public.blob.vercel-storage.com/Tricode-logo-AkL8KF3rRdG2rTS1CMkfk99qIdZ74H.jpg"
          alt="Logo geométrico cuadrado"
          layout="fill"
          objectFit="cover"
        />
      </motion.div>
    </section>
  )
}