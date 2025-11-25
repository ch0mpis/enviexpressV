package com.enviexpress.Enviexpress.repositories;

import com.enviexpress.Enviexpress.entities.EnvioRuta;
import com.enviexpress.Enviexpress.entities.EnvioRutaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnviorutaRepository extends JpaRepository<EnvioRuta, EnvioRutaId> {
}