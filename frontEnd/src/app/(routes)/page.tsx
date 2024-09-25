import Link from 'next/link';

export default function Home() {
  return (
    <div className="min-h-screen flex items-center justify-center flex-col">
      <h1 className="text-5xl font-bold mb-8">Bienvenido a Bienestar</h1>
      <div className="space-x-4">
        <Link href="/activity/explore" className="bg-blue-500 text-white py-2 px-4 rounded">
          Explorar Actividades
        </Link>
        <Link className="bg-green-500 text-white py-2 px-4 rounded" href="/progress">
        Ver Progreso
        </Link>
      </div>
    </div>
  );
}
