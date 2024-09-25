"use client"
import { useEffect, useState } from 'react';
import { getUserProgress } from '../../services/api';

// Definir el tipo de los datos de progreso
interface ProgressEntry {
  id: string;
  objetivo: string;
  progreso: string;
}

export default function Progress() {
  // Establecer el tipo del estado como un array de ProgressEntry
  const [progress, setProgress] = useState<ProgressEntry[]>([]);

  useEffect(() => {
    getUserProgress().then(setProgress);
  }, []);

  return (
    <div className="min-h-screen p-8">
      <h1 className="text-4xl font-bold mb-6">Mi Progreso</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {progress.map((entry) => (
          <div key={entry.id} className="p-4 border rounded shadow">
            <h2 className="text-xl font-semibold">{entry.objetivo}</h2>
            <p><strong>Progreso:</strong> {entry.progreso}</p>
          </div>
        ))}
      </div>
    </div>
  );
}
