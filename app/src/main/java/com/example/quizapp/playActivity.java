package com.example.quizapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class playActivity extends AppCompatActivity {

    String[] question_list = {
            "Apa ibukota Indonesia?",
            "Pulau terbesar di Indonesia adalah?",
            "Siapa Presiden pertama Indonesia?",
            "Kapan Indonesia merdeka?",
            "Apa bahasa resmi Indonesia?",
            "Candi Borobudur terletak di provinsi mana?",
            "Apa mata uang Indonesia?",
            "Apa nama lagu kebangsaan Indonesia?",
            "Gunung tertinggi di Indonesia adalah?",
            "Hewan khas Indonesia yang terkenal adalah?",
            "Apa julukan untuk Bali?",
            "Di kota mana Taman Mini Indonesia Indah berada?",
            "Sungai terpanjang di Indonesia adalah?",
            "Apa nama bendera Indonesia?",
            "Apa nama gedung parlemen Indonesia?",
            "Siapa pahlawan nasional yang dikenal sebagai 'Bapak Pendidikan Nasional'?",
            "Pulau Komodo terkenal dengan hewan apa?",
            "Siapa yang dianggap sebagai proklamator kemerdekaan Indonesia?",
            "Apa julukan untuk kota Yogyakarta?",
            "Apa makanan khas Padang yang terkenal?",
            "Siapa Wakil Presiden Indonesia pada tahun 2020?",
            "Di kota mana terdapat Jembatan Ampera?",
            "Danau terbesar di Indonesia adalah?",
            "Apa nama pakaian tradisional Bali untuk pria?",
            "Apa nama tarian tradisional dari Aceh?",
            "Suku terbesar di Indonesia adalah?",
            "Apa nama masjid terbesar di Indonesia?",
            "Apa nama suku asli Papua?",
            "Di kota mana terdapat Bandara Soekarno-Hatta?",
            "Apa nama upacara adat dari Toraja?"
    };

    String[] choose_list = {
            "Jakarta", "Bandung", "Surabaya", "Medan",
            "Sumatra", "Jawa", "Kalimantan", "Papua",
            "Sukarno", "Suharto", "Habibie", "Gus Dur",
            "1945", "1949", "1950", "1955",
            "Jawa", "Indonesia", "Melayu", "Sunda",
            "Jawa Tengah", "Jawa Barat", "Yogyakarta", "Jawa Timur",
            "Rupiah", "Dollar", "Yen", "Ringgit",
            "Indonesia Raya", "Garuda Pancasila", "Bagimu Negeri", "Satu Nusa Satu Bangsa",
            "Gunung Rinjani", "Gunung Semeru", "Gunung Kerinci", "Gunung Jaya Wijaya",
            "Harimau Sumatra", "Orangutan", "Komodo", "Badak Jawa",
            "Pulau Dewata", "Pulau Seribu", "Pulau Zamrud", "Pulau Merah",
            "Surabaya", "Bandung", "Jakarta", "Yogyakarta",
            "Sungai Mahakam", "Sungai Musi", "Sungai Kapuas", "Sungai Barito",
            "Merah Putih", "Merah Biru", "Putih Hijau", "Putih Merah",
            "Gedung MPR/DPR", "Istana Negara", "Gedung Sate", "Balai Kota",
            "Ki Hajar Dewantara", "RA Kartini", "Cut Nyak Dien", "Sudirman",
            "Komodo", "Banteng", "Badak", "Kanguru",
            "Sukarno", "Suharto", "Habibie", "Yudhoyono",
            "Kota Pelajar", "Kota Bunga", "Kota Pahlawan", "Kota Seribu Sungai",
            "Rendang", "Sate", "Nasi Goreng", "Gado-gado",
            "Ma'ruf Amin", "Jusuf Kalla", "Boediono", "Megawati",
            "Palembang", "Medan", "Balikpapan", "Makassar",
            "Danau Toba", "Danau Maninjau", "Danau Singkarak", "Danau Sentani",
            "Kain Cawat", "Baju Adat", "Udeng", "Peci",
            "Tari Pendet", "Tari Saman", "Tari Legong", "Tari Kecak",
            "Jawa", "Sunda", "Batak", "Minangkabau",
            "Masjid Istiqlal", "Masjid Agung", "Masjid Kubah Emas", "Masjid Raya",
            "Asmat", "Dani", "Batak", "Toraja",
            "Jakarta", "Surabaya", "Medan", "Makassar",
            "Rambu Solo", "Ngaben", "Tedhak Siten", "Seren Taun"
    };

    String[] correct_list = {
            "Jakarta", "Kalimantan", "Sukarno", "1945", "Indonesia",
            "Jawa Tengah", "Rupiah", "Indonesia Raya", "Gunung Jaya Wijaya", "Komodo",
            "Pulau Dewata", "Jakarta", "Sungai Kapuas", "Merah Putih", "Gedung MPR/DPR",
            "Ki Hajar Dewantara", "Komodo", "Sukarno", "Kota Pelajar", "Rendang",
            "Ma'ruf Amin", "Palembang", "Danau Toba", "Udeng", "Tari Saman",
            "Jawa", "Masjid Istiqlal", "Asmat", "Jakarta", "Rambu Solo"
    };

    TextView cpt_question, text_question;
        Button btn_choose1, btn_choose2, btn_choose3, btn_choose4, btn_next;
        int currentQuestion = 0;
        int scorePlayer = 0;
        boolean isclickBtn = false;
        String valueChoose = "";
        Button btn_click;

        List<Integer> selectedIndices;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_play);

            cpt_question = findViewById(R.id.cpt_question);
            text_question = findViewById(R.id.text_question);
            btn_choose1 = findViewById(R.id.btn_choose1);
            btn_choose2 = findViewById(R.id.btn_choose2);
            btn_choose3 = findViewById(R.id.btn_choose3);
            btn_choose4 = findViewById(R.id.btn_choose4);
            btn_next = findViewById(R.id.btn_next);

            findViewById(R.id.image_back).setOnClickListener(
                    a -> finish()
            );

            // Memilih 10 pertanyaan secara acak
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < question_list.length; i++) {
                indices.add(i);
            }
            Collections.shuffle(indices);
            selectedIndices = indices.subList(0, 10);

            remplirData();

            btn_next.setOnClickListener(
                    view -> {
                        if (isclickBtn) {
                            isclickBtn = false;

                            if (!valueChoose.equals(correct_list[selectedIndices.get(currentQuestion)])) {
                                Toast.makeText(playActivity.this, "Jawaban salah!", Toast.LENGTH_LONG).show();
                                btn_click.setBackgroundResource(R.drawable.background_btn_erreur);
                            } else {
                                Toast.makeText(playActivity.this, "Jawaban benar!", Toast.LENGTH_LONG).show();
                                btn_click.setBackgroundResource(R.drawable.background_btn_correct);
                                scorePlayer++;
                            }
                            new Handler().postDelayed(() -> {
                                if (currentQuestion != selectedIndices.size() - 1) {
                                    currentQuestion = currentQuestion + 1;
                                    remplirData();
                                    valueChoose = "";
                                    btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);
                                } else {
                                    Intent intent = new Intent(playActivity.this, ResultActivity.class);
                                    intent.putExtra("Hasil", scorePlayer);
                                    startActivity(intent);
                                    finish();
                                }
                            }, 2000);
                        } else {
                            Toast.makeText(playActivity.this, "Anda harus memilih satu", Toast.LENGTH_LONG).show();
                        }
                    }
            );
        }

        void remplirData() {
            cpt_question.setText((currentQuestion + 1) + "/" + selectedIndices.size());
            text_question.setText(question_list[selectedIndices.get(currentQuestion)]);

            btn_choose1.setText(choose_list[4 * selectedIndices.get(currentQuestion)]);
            btn_choose2.setText(choose_list[4 * selectedIndices.get(currentQuestion) + 1]);
            btn_choose3.setText(choose_list[4 * selectedIndices.get(currentQuestion) + 2]);
            btn_choose4.setText(choose_list[4 * selectedIndices.get(currentQuestion) + 3]);
        }

        public void ClickChoose(View view) {
            btn_click = (Button) view;

            if (isclickBtn) {
                btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
                btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
                btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
                btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);
            }
            chooseBtn();
        }

        void chooseBtn() {
            btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
            isclickBtn = true;
            valueChoose = btn_click.getText().toString();
        }
    }
